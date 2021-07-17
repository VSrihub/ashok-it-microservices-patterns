import axios from 'axios';

const LOGIN_SERVICE_URL = "http://localhost:9097/api/token";
//const LOGIN_SERVICE_URL = "https://dev-3s3dknax.auth0.com/oauth/token";

class LoginService{

    doLogin(loginData) {
        let configOptions = {
            "headers": {
                "Content-Type":"application/json"
            }
        }
        // let auth0Data = {
        //     "username": loginData.username,
        //     "password": loginData.password,
        //     "grant_type": "password",
        //     "scope":"openid email address phone offline_access"
        // }
        let auth0Data = {
            "username": loginData.username,
            "password": loginData.password
        }
        return axios.post(LOGIN_SERVICE_URL, loginData, configOptions);
    }
}
export default new LoginService();