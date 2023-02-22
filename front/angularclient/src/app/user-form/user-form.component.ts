import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../user';
import { UserServiceService } from '../user-service.service';
import { UserType } from '../user-type';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  user: User;

  usertypes: UserType[];

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserServiceService) {
    this.user = new User();
  }

  onSubmit() {
    this.userService.saveUser(this.user).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/users']);
  }

  ngOnInit(): void {
    this.userService.findAllTypes().subscribe(data => {
      this.usertypes = data;
    });
  }

}
