import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from 'src/app/Models/admin';
import { AdminService } from 'src/app/Services/admin.service';

@Component({
  selector: 'app-register-admin',
  templateUrl: './register-admin.component.html',
  styleUrls: ['./register-admin.component.css'],
})
export class RegisterAdminComponent {
  admin: Admin = {
    adminId: 0,
    email: '',
    password: '',
  };

  constructor(private adminService: AdminService, private router: Router) {}

  registerAdmin(): void {
    this.adminService.registerAdmin(this.admin).subscribe(
      (response) => {
        console.log('Admin registered successfully!', response);
        this.router.navigate(['/get-all-doctor']);
      },
      (error) => {
        console.error('Error registering Admin!', error);
      }
    );
  }
}
