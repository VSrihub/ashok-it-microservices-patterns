import axios from 'axios';

const DEPARTMENT_SERVICE_URL = "http://localhost:8095/api/medilab-department-service/api/mediplab-department";

class DepartmentService{

    createDept(deptData) {
        let configOptions = {
            "headers": {
                "Content-Type": "application/json",
                "Authorization": "Bearer " + localStorage.getItem("access_token")
            }
        }
        return axios.post(DEPARTMENT_SERVICE_URL, deptData, configOptions);
    }

    findAllDept() {
        let configOptions = {
            "headers": {
                "Authorization": "Bearer " + localStorage.getItem("access_token")
            }
        }
        return axios.get(DEPARTMENT_SERVICE_URL, configOptions);
        }
}
export default new DepartmentService();
 