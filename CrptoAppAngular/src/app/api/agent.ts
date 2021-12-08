import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { User } from "../model/user";

@Injectable({
    providedIn: 'root'
})
export class Agent {
    url: 'http://localhost:8080/api';

    constructor(private http: HttpClient) {}

    //get user
    getUser(username: string | string, password: string | string): Promise<User> {
        return this.http.post<User>(this.url + '/login', {
            'username': username,
            'password': password
        }).toPromise();
    }
}