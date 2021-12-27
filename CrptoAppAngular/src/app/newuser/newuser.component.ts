import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Agent } from 'src/app/api/agent';
import { User } from 'src/app/model/user';

@Component({
  selector: 'app-newuser',
  templateUrl: './newuser.component.html',
  styleUrls: ['./newuser.component.css']
})
export class NewuserComponent implements OnInit {

  @ViewChild('f', { static: false }) signupForm: NgForm;

  constructor(private router: Router, private service: Agent) { }

  ngOnInit(): void {
  }

  createNewUser() {
    let userInputUsername = this.signupForm.value.userData.username;
    let userInputPassword = this.signupForm.value.userData.password;
    let userInputEmail = this.signupForm.value.userData.email;

    this.service.postUser(userInputUsername, userInputPassword, userInputEmail);

    this.router.navigate(['homepage']);
  }

}
