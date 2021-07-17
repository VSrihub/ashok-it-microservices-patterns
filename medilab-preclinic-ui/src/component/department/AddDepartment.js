import React, { Component } from 'react'
import DepartmentService from '../../service/DepartmentService';
import DashboardHeader from '../dashboard/DashboardHeader'
export class AddDepartment extends Component {
    constructor(props) {
        super(props);
        this.state = {
            deptData: {
                "name": "",
                "description": "",
                "status":"false"
            },
            createDept:this.createDept.bind(this),
            readDeptData: this.readDeptData.bind(this)
        }
    }
    createDept = () => {
        console.log("i am in create department" + JSON.stringify(this.state.deptData));
        DepartmentService
            .createDept(JSON.stringify(this.state.deptData))
            .then((resp) => {
                console.log("the data from service is " + JSON.stringify(resp.data));
                let deptId = resp.data.deptId;
                if (deptId > 0) {
                    this.setState(Object.assign(this.state.deptData, JSON.stringify(resp.data)));
                    this.props.history.push("/departments");
                }
            }, (error) => {
                console.log("the error data from service is " + JSON.stringify(error.data));
        })
    }

    readDeptData = (e) => {
        this.setState(
            Object.assign(this.state.deptData,{[e.target.name]:e.target.value})
        )
    }
    render() {
        return (
            <div>
                <DashboardHeader />
                <div class="page-wrapper">
                    <div class="content">
                        <div class="row">
                            <div class="col-lg-8 offset-lg-2">
                                <h4 class="page-title">Add Department</h4>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-8 offset-lg-2">
                                <div class="form-group">
                                    <label>Department Name</label>
                                    <input class="form-control" type="text"
                                        name="name"
                                        onChange={this.readDeptData} />
                                </div>
                                <div class="form-group">
                                    <label>Description</label>
                                    <textarea cols="30" rows="4"
                                        class="form-control" name="description"
                                        onChange={this.readDeptData}></textarea>
                                </div>
                                <div class="form-group">
                                <label class="display-block">Department Status</label>
								<div class="form-check form-check-inline">
                                        <input class="form-check-input"
                                            type="radio"
                                            name="status"
                                            id="product_active"
                                            value="true"
                                            onChange={this.readDeptData}
                                            checked/>
									<label class="form-check-label" for="product_active">
									Active
									</label>
								</div>
								<div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" name="status"
                                            id="product_inactive"
                                            value="false"
                                            onChange={this.readDeptData}/>
									<label class="form-check-label" for="product_inactive">
									Inactive
									</label>
                                    </div>
                                    <div class="m-t-20 text-center">
                                <button class="btn btn-primary submit-btn" onClick={this.createDept}>Create Department</button>
                            </div>
                                    
                            </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default AddDepartment
