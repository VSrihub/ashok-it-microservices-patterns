import React, { Component } from 'react'
import DepartmentService from '../../service/DepartmentService'
import DashboardHeader from '../dashboard/DashboardHeader'

export class Department extends Component {

    constructor(props) {
        super(props);
        
        this.state = {
            deptList: []
        }
        
    }
    
    
    componentDidMount() {
        DepartmentService
            .findAllDept()
            .then((resp) => {
                console.log("response data is " + JSON.stringify(resp.data));
                this.setState({deptList: resp.data});
            }, (error) => {
                console.log("error response data is " + JSON.stringify(error.data));
        })
    }
    render() {
        return (
            <div>
                <DashboardHeader />
                
                <div class="page-wrapper">
                   
            <div class="content">
                <div class="row">
                    <div class="col-sm-5 col-5">
                        <h4 class="page-title">Departments</h4>
                    </div>
                    <div class="col-sm-7 col-7 text-right m-b-30">
                        <a href="./addDepartment" class="btn btn-primary btn-rounded"><i class="fa fa-plus"></i> Add Department</a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table class="table table-striped custom-table mb-0 datatable">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Department Name</th>
                                        <th>Status</th>
                                        <th class="text-right">Action</th>
                                    </tr>
                                </thead>
                                        <tbody>
                                            {this.state.deptList.map((dept) => (
                                            <tr>
                                            <td>{dept.deptId}</td>
                                                    <td>{dept.name}</td>
                                                    {!dept.status &&
                                                         <td><span class="custom-badge status-red">inactive</span></td>
                                                    }
                                                    {dept.status &&
                                                         <td><span class="custom-badge status-green">active</span></td>
                                                    }
                                            
                                            <td class="text-right">
                                                <div class="dropdown dropdown-action">
                                                    <a href="#" class="action-icon dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><i class="fa fa-ellipsis-v"></i></a>
                                                    <div class="dropdown-menu dropdown-menu-right">
                                                        <a class="dropdown-item" href="edit-department.html"><i class="fa fa-pencil m-r-5"></i> Edit</a>
                                                        <a class="dropdown-item" href="#" data-toggle="modal" data-target="#delete_department"><i class="fa fa-trash-o m-r-5"></i> Delete</a>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>
                                       
                                       ) )}    
                                    
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                    </div>
                    </div>
            </div>
        )
    }
}

export default Department
