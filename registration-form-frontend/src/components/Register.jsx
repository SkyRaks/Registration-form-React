import React, { Component } from 'react';
import HomeService from '../services/HomeService';

class Register extends Component {
    constructor(props) {
        super(props)

        this.state = {
            username: '',
            email: '',
            password: ''
        }
        this.homePage = this.homePage.bind(this);
        this.changeUserNameHandler = this.changeUserNameHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.saveUser = this.saveUser.bind(this);
    }

    homePage(){
        this.props.history.push('/home');
    }

    saveUser = (e) => {
        e.preventDefault();
        let user = {username: this.state.username, email: this.state.email, password: this.state.password};
        console.log('user => ' + JSON.stringify(user));

        HomeService.createUser(user).then(res => {
            this.props.history.push('/home');
        });
    }

    changeUserNameHandler = (event) => {
        this.setState({username: event.target.value});
    }

    changeEmailHandler = (event) => {
        this.setState({email: event.target.value});
    }

    changePasswordHandler = (event) => {
        this.setState({password: event.target.value});
    }

    render() {
        return (
            <div class="col-4 mx-auto my-4">
                <h1>Registration</h1>

                <form>
                    <div class="mb-4">
                        <label class="form-label">Username</label>
                        <input name="username" class="form-control" value={this.state.username} onChange={this.changeUserNameHandler}/>
                    </div>
                    <div class="mb-4">
                        <label class="form-label">Email address</label>
                        <input name="email" class="form-control" value={this.state.email} onChange={this.changeEmailHandler}/>
                    </div>
                    <div class="mb-4">
                        <label class="form-label">Password</label>
                        <input name="password" class="form-control" value={this.state.password} onChange={this.changePasswordHandler}/>
                    </div>
                    <button type="submit" class="btn btn-success"onClick={this.saveUser}>Submit</button>
                    <button className="btn btn-danger" style={{marginLeft: "10px"}} onClick={this.homePage}>Cancel</button>
                </form>

            </div>
        );
    }
}

export default Register;