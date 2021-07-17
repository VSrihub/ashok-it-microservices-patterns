import React, { Component } from 'react'

export class DashboardHeader extends Component {
    render() {
        return (
            <div>
                <div className="header">
                <div className="header-left">
                        <a href="index-2.html" className="logo">
                            <img src="assets/img/logo.png" width="35" height="35" alt="" />
                            <span>Preclinic</span>
                        </a>
                    </div>
                    <a id="toggle_btn" href="javascript:void(0);"></a>
                    <a id="toggle_btn" href="#"><i className="fa fa-bars"></i></a>
                    <a id="mobile_btn" className="mobile_btn float-left" href="#sidebar"><i className="fa fa-bars"></i></a>
                    <ul className="nav user-menu float-right">
                        <li className="nav-item dropdown d-none d-sm-block">
                            <a href="#" className="dropdown-toggle nav-link" data-toggle="dropdown">
                                <i className="fa fa-bell-o"></i>
                                <span className="badge badge-pill bg-danger float-right">3</span></a>
                            
                                <div className="dropdown-menu notifications">
                        <div className="topnav-dropdown-header">
                            <span>Notifications</span>
                        </div>
                        <div className="drop-scroll">
                            <ul className="notification-list">
                                <li className="notification-message">
                                    <a href="activities.html">
                                        <div className="media">
											<span className="avatar">
												<img alt="John Doe" src="assets/img/user.jpg" className="img-fluid"/>
											</span>
											<div className="media-body">
												<p className="noti-details"><span className="noti-title">John Doe</span> added new task <span className="noti-title">Patient appointment booking</span></p>
												<p className="noti-time"><span className="notification-time">4 mins ago</span></p>
											</div>
                                        </div>
                                    </a>
                                </li>
                                <li className="notification-message">
                                    <a href="activities.html">
                                        <div className="media">
											<span className="avatar">V</span>
											<div className="media-body">
												<p className="noti-details"><span className="noti-title">Tarah Shropshire</span> changed the task name <span className="noti-title">Appointment booking with payment gateway</span></p>
												<p className="noti-time"><span className="notification-time">6 mins ago</span></p>
											</div>
                                        </div>
                                    </a>
                                </li>
                                <li className="notification-message">
                                    <a href="activities.html">
                                        <div className="media">
											<span className="avatar">L</span>
											<div className="media-body">
												<p className="noti-details"><span className="noti-title">Misty Tison</span> added <span className="noti-title">Domenic Houston</span> and <span className="noti-title">Claire Mapes</span> to project <span className="noti-title">Doctor available module</span></p>
												<p className="noti-time"><span className="notification-time">8 mins ago</span></p>
											</div>
                                        </div>
                                    </a>
                                </li>
                                <li className="notification-message">
                                    <a href="activities.html">
                                        <div className="media">
											<span className="avatar">G</span>
											<div className="media-body">
												<p className="noti-details"><span className="noti-title">Rolland Webber</span> completed task <span className="noti-title">Patient and Doctor video conferencing</span></p>
												<p className="noti-time"><span className="notification-time">12 mins ago</span></p>
											</div>
                                        </div>
                                    </a>
                                </li>
                                <li className="notification-message">
                                    <a href="activities.html">
                                        <div className="media">
											<span className="avatar">V</span>
											<div className="media-body">
												<p className="noti-details"><span className="noti-title">Bernardo Galaviz</span> added new task <span className="noti-title">Private chat module</span></p>
												<p className="noti-time"><span className="notification-time">2 days ago</span></p>
											</div>
                                        </div>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div className="topnav-dropdown-footer">
                            <a href="activities.html">View all Notifications</a>
                        </div>
                    </div>
                        </li>
                        <li class="nav-item dropdown d-none d-sm-block">
                    <a href="javascript:void(0);" id="open_msg_box" class="hasnotifications nav-link"><i class="fa fa-comment-o"></i> <span class="badge badge-pill bg-danger float-right">8</span></a>
                        </li>
                        <li class="nav-item dropdown has-arrow">
                        <a href="#" class="dropdown-toggle nav-link user-link" data-toggle="dropdown">
                        <span class="user-img">
							<img class="rounded-circle" src="assets/img/user.jpg" width="24" alt="Admin"/>
							<span class="status online"></span>
						</span>
						<span>Admin</span>
                    </a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="profile.html">My Profile</a>
						<a class="dropdown-item" href="edit-profile.html">Edit Profile</a>
						<a class="dropdown-item" href="settings.html">Settings</a>
						<a class="dropdown-item" href="login.html">Logout</a>
                            </div>
                            <div class="dropdown mobile-user-menu float-right">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-ellipsis-v"></i></a>
                <div class="dropdown-menu dropdown-menu-right">
                    <a class="dropdown-item" href="profile.html">My Profile</a>
                    <a class="dropdown-item" href="edit-profile.html">Edit Profile</a>
                    <a class="dropdown-item" href="settings.html">Settings</a>
                    <a class="dropdown-item" href="login.html">Logout</a>
                </div>
                            </div>
                            <div class="sidebar" id="sidebar">
                            <div class="sidebar-inner slimscroll">
                                    <div id="sidebar-menu" class="sidebar-menu">
                                        <ul>
                                        <li class="menu-title">Main</li>
                        <li class="active">
                            <a href="index-2.html"><i class="fa fa-dashboard"></i> <span>Dashboard</span></a>
                        </li>
						<li>
                            <a href="doctors.html"><i class="fa fa-user-md"></i> <span>Doctors</span></a>
                        </li>
                        <li>
                            <a href="patients.html"><i class="fa fa-wheelchair"></i> <span>Patients</span></a>
                        </li>
                        <li>
                            <a href="appointments.html"><i class="fa fa-calendar"></i> <span>Appointments</span></a>
                        </li>
                        <li>
                            <a href="schedule.html"><i class="fa fa-calendar-check-o"></i> <span>Doctor Schedule</span></a>
                        </li>
                        <li>
                            <a href="./departments"><i class="fa fa-hospital-o"></i> <span>Departments</span></a>
                        </li>
                                            </ul>
                                    </div>
                                    </div>
                                </div>
                </li>
                    </ul>









                    </div>
            </div>
        )
    }
}

export default DashboardHeader
