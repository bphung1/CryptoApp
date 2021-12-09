import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Agent } from 'src/app/api/agent';
import { User } from 'src/app/model/user';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  isLoaded = false;
  user: User;

  constructor(private router: Router, private service: Agent) { }

  ngOnInit(): void {
    this.getUser();
  }

  getUser() {
    this.service.getUser('someone', 'password').then(user => {
      this.isLoaded = false;
      this.user = user;
      this.isLoaded = true;
    });
  }

  login() {
    this.router.navigate(['portfolio']);
  }

}
