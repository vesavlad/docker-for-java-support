import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Image} from "../interfaces/image.model";
import {environment} from "../../environments/environment";
import {Container} from "../interfaces/container.model";

@Injectable({
    providedIn: 'root'
})
export class DockerApiService {

    private baseUrl = environment.apiURL;

    constructor(private http: HttpClient) {
    }

    public getImages(): Observable<Image[]> {
        return this.http.get<Image[]>(`${this.baseUrl}/images`);
    }

    public getContainers(): Observable<Container[]> {
        return this.http.get<Container[]>(`${this.baseUrl}/containers`);
    }
}
