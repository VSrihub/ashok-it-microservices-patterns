import {Switch,Route} from 'react-router-dom'
import Dashboard from './component/dashboard/Dashboard';
import AddDepartment from './component/department/AddDepartment';
import Department from './component/department/Department';
import Home from './component/Home'
import Login from './component/login/Login';
import Signup from './component/signup/Signup';
function ApplicationRouter() {
    return (
        <div>
            <Switch>
                <Route exact path="/" component={Home} />
                <Route exact path="/signup" component={Signup} />
                <Route exact path="/login" component={Login} />
                <Route exact path="/dashboard" component={Dashboard} />
                <Route exact path="/departments" component={Department} />
                <Route exact path="/addDepartment" component={AddDepartment}/>
            </Switch>
      </div>
    );
  }
  
  export default ApplicationRouter;
  