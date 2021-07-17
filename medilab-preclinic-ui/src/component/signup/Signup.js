import React, { Component } from 'react'
import SignupService from '../../service/SignupService';
import Header from '../Header'

export class Signup extends Component {
    constructor(props) {
        super(props);
        this.state = {
            SignupData: {
                    "fname": "",
                    "lname": "",
                    "userId": "",
                    "email": "",
                    "password": "",
                    "mobile": "",
                    "termsAndConditions":""                        
            },
            register: this.register.bind(this),
            readRegData: this.readRegData.bind(this),
            isRegCompleted:false
        }    
        
    }

    readRegData = (e) => {
        console.log("i am in read reg data");
        this.setState(
            Object.assign(this.state.SignupData,
                { [e.target.name]: e.target.value}))
    }

    register = () => {
        console.log("i am in register method" + JSON.stringify(this.state.SignupData));
        let signupRequest = JSON.stringify(this.state.SignupData);
        SignupService
            .doSignup(signupRequest)
            .then((resp) => {
                console.log("backedn call is successa and the resp is "
                    + JSON.stringify(resp.data));
                let regId = resp.data.id;
                if (regId != null && regId > 0) {
                    this.setState({isRegCompleted:true})
                }
            }, (error) => {
                console.log("backedn call is fail and the error resp is "
                    + JSON.stringify(error.data));
            })
        
    }
    
    render() {
        return (
            <div>
                <Header/>
                    <div class="main-wrapper  account-wrapper">
                    <div class="account-page">
                        <div class="account-center">
                            <div class="account-box">
                            <div class="account-logo">
                                    <a href="#"><img src="assets/img/logo-dark.png" alt="" /></a>
                                </div>
                                {this.state.isRegCompleted &&
                                    <div class="alert alert-primary" role="alert">
                                    Congratulations. your registration has been done successfully.
                                    Please click <a href="#" class="alert-link">Here</a>.to login.
                                    </div>
                                }
                                <div class="form-group">
                                    <label>First Name</label>
                                    <input type="text"
                                        class="form-control"
                                        name="fname"
                                        onChange={this.readRegData}/>
                                </div>
                                <div class="form-group">
                                    <label>Last Name</label>
                                    <input type="text" class="form-control"
                                        name="lname"
                                        onChange={this.readRegData}/>
                        </div>
                                <div class="form-group">
                                    <label>Username</label>
                                    <input type="text" class="form-control"
                                        name="userId"
                                        onChange={this.readRegData}/>
                        </div>
                        <div class="form-group">
                            <label>Email Address</label>
                                    <input type="email" class="form-control"
                                        name="email"
                                        onChange={this.readRegData}/>
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                                    <input type="password" class="form-control"
                                        name="password"
                                        onChange={this.readRegData}/>
                        </div>
                        <div class="form-group">
                            <label>Mobile Number</label>
                                    <input type="text" class="form-control"
                                        name="mobile"
                                        onChange={this.readRegData}/>
                        </div>
                        <div class="form-group checkbox">
                            <label>
                                        <input type="checkbox" name="termsAndConditions"
                                        onChange={this.readRegData}/> I have read and agree the Terms & Conditions
                            </label>
                        </div>
                        <div class="form-group text-center">
                            <button class="btn btn-primary account-btn" type="submit" onClick={this.register}>Signup</button>
                        </div>
                        <div class="text-center login-link">
                            Already have an account? <a href="./login">Login</a>
                        </div>
                                </div>
                            </div>
                        </div>
                </div>
            </div>
        )
    }
}

export default Signup
