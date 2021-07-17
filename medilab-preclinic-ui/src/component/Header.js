import React, { Component } from 'react'

export class Header extends Component {
    render() {
        return (
    <div>
                <div id="topbar" class="d-none d-lg-flex align-items-center fixed-top">
                <div class="container d-flex">
                <div class="contact-info mr-auto">
                    <i class="icofont-envelope"></i> <a href="mailto:contact@example.com">contact@example.com</a>
                    <i class="icofont-phone"></i> +1 5589 55488 55
                    <i class="icofont-google-map"></i> A108 Adam Street, NY
                </div>
                <div class="social-links">
                    <a href="#" class="twitter"><i class="icofont-twitter"></i></a>
                    <a href="#" class="facebook"><i class="icofont-facebook"></i></a>
                    <a href="#" class="instagram"><i class="icofont-instagram"></i></a>
                    <a href="#" class="skype"><i class="icofont-skype"></i></a>
                    <a href="#" class="linkedin"><i class="icofont-linkedin"></i></a>
                </div>
                        
                <header id="header" class="fixed-top">
                    <div class="container d-flex align-items-center">
                                <h1 class="logo mr-auto">
                                    <a href="index.html">Medilab</a></h1>
                    
                    <nav class="nav-menu d-none d-lg-block">
                        <ul>
                        <li class="active"><a href="index.html">Home</a></li>
                        <li><a href="#about">About</a></li>
                        <li><a href="#services">Services</a></li>
                        <li><a href="#departments">Departments</a></li>
                                        <li><a href="#doctors">Doctors</a></li>
                                        <li><a href="./signup">Sign up</a></li>
                                        <li><a href="./login">Login</a></li>
                        
                                    <li><a href="#contact">Contact</a></li>
                                </ul>
                            </nav>
                            
                            <a href="#appointment" class="appointment-btn scrollto">Make an Appointment</a>
</div>
                        </header>
                        
    </div>
                </div>
                </div>
            
        )
    }
}

export default Header
