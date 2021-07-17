
import axios from "axios";


const SIGNUP_SERVICE_URL = "http://localhost:9095/api/mediplab-user";

class SinupService{

    
    doSignup(signupData) {
        console.log("doSignup method of service " + signupData);
        let config = {
            "headers": {
                "Content-Type":"application/json"
            }
        }
        return axios.post(SIGNUP_SERVICE_URL, signupData, config);
    }
    
}
export default new SinupService();