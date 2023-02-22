import { Component, OnInit } from '@angular/core';
import { UserServiceService } from '../user-service.service';
import { UserType } from '../user-type';

@Component({
  selector: 'app-type-list',
  templateUrl: './type-list.component.html',
  styleUrls: ['./type-list.component.css']
})
export class TypeListComponent implements OnInit {
  
  userTypes: UserType[];

  constructor(private userService: UserServiceService) {}

  ngOnInit(): void {
    this.userService.findAllTypes().subscribe(data => {
      this.userTypes = data;
    });
  }
  
}
