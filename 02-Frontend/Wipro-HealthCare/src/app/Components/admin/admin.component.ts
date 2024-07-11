import { Component } from '@angular/core';
import { Admin } from 'src/app/Models/admin';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {

  admin! :Admin;

}
