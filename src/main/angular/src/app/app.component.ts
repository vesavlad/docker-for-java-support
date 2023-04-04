import {Component, OnDestroy, OnInit} from '@angular/core';
import {DockerApiService} from "./services/docker-api.service";
import {combineLatestWith, Subscription} from "rxjs";
import {Container} from "./interfaces/container.model";
import {Image} from "./interfaces/image.model";

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy {

    private subs: Subscription[] = [];
    public containers: Container[] = [];
    public images: Image[] = [];

    constructor(private dockerApiService: DockerApiService) {
    }

    ngOnInit() {
        this.subs.push(
            this.dockerApiService.getImages()
                .pipe(combineLatestWith(this.dockerApiService.getContainers()))
                .subscribe({
                    next: ([images, containers]) => {
                        this.images = images;
                        this.containers = containers;
                    }
                })
        )
    }

    ngOnDestroy(): void {
        this.subs.forEach(s => s.unsubscribe());
    }
}
