import React, { Component } from 'react'
import LoginService from '../../service/LoginService';
import Header from '../Header'

export class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            loginData: {
                "username": "",
                "password":""
            },
            doLogin: this.doLogin.bind(this),
            readLoginData: this.readLoginData.bind(this),
            dataSubmitted: false,
            loginSuccess: false
        }
    }
    doLogin = () => {
        console.log("i am in doLogin method");
        console.log("and the login data is " + JSON.stringify(this.state.loginData));
        this.setState({ dataSubmitted: true });
        LoginService
            .doLogin(JSON.stringify(this.state.loginData))
            .then((resp) => {
                console.log("response from service s " + resp.data);
                let token = resp.data.access_token;
                if (token != null) {
                    console.log("login success and the token is " + token);
                    this.setState({ loginSuccess: true });
                    localStorage.setItem("access_token", token);
                    this.props.history.push("/dashboard");
                }
            }, (error) => {
                console.log("error response from service s " + error.data);
        })
    }
    readLoginData = (e) => {
        console.log("i am in read Login Data");
        this.setState(
            Object.assign(this.state.loginData,{[e.target.name]:e.target.value
            })
        )
    }
    render() {
        return (
            <div>
                <Header />
                <section id="hero" class="d-flex align-items-center">
                <div class="main-wrapper account-wrapper">
                    <div class="account-page">
                        <div class="account-center">
                            <div class="account-box">
                                <div class="rounded-0" alt="">
                                    <a href="#">
                                            <img src="assets/img/logo-dark.png" 
                                            /></a>
                                    </div>
                                    {this.state.dataSubmitted &&
                                        !this.state.loginSuccess &&
                                        <div class="spinner-border text-info" role="status">
                                        <span class="visually-hidden">Loading...</span>
                                    </div>                                    
                                    }
                                    <div class="form-group">
                                        <label>Email</label>
                                        <input type="text"
                                            autofocus=""
                                            class="form-control"
                                            name="username"
                                        onChange={this.readLoginData}/>
                                    </div>
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input type="password"
                                            class="form-control"
                                            name="password"
                                            onChange={this.readLoginData}/>
                                    </div>
                                    <div class="form-group text-right">
                                    <a href="#">Forgot your password?</a>
                                    </div>
                                    <div class="form-group text-center">
                                        <button type="submit"
                                            class="btn btn-primary account-btn"
                                        onClick={this.doLogin}>Login</button>
                                        </div>
                                    <div class="text-center register-link">
                                                        Don’t have an account? <a href="./signup">Register Now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </section>
            </div>
        )
    }
}

export default Login
