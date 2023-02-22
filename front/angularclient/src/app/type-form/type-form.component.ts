import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserServiceService } from '../user-service.service';
import { UserType } from '../user-type';

@Component({
  selector: 'app-type-form',
  templateUrl: './type-form.component.html',
  styleUrls: ['./type-form.component.css']
})
export class TypeFormComponent {
  type: UserType;

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserServiceService) {
    this.type = new UserType();
  }

  onSubmit() {
    this.userService.saveType(this.type).subscribe(result => this.gotoTypeList());
  }

  gotoTypeList() {
    this.router.navigate(['/usertypes']);
  }
}
