import {TestBed} from '@angular/core/testing';

import {DockerApiService} from './docker-api.service';

describe('DockerApiService', () => {
    let service: DockerApiService;

    beforeEach(() => {
        TestBed.configureTestingModule({});
        service = TestBed.inject(DockerApiService);
    });

    it('should be created', () => {
        expect(service).toBeTruthy();
    });
});
