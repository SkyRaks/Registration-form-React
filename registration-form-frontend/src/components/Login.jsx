import React, { Component } from 'react';
import HomeService from '../services/HomeService';

class Login extends Component {
    constructor(props) {
        super(props)

        this.state = {
            email: '',
            password: ''
        }
        this.homePage = this.homePage.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.LogInUser = this.LogInUser.bind(this);
    }

    homePage(){
        this.props.history.push('/home');
    }

    LogInUser = (e) => {
        e.preventDefault();
        let user = {email: this.state.email, password: this.state.password};

        HomeService.findUser(user).then(res => {
            if (res.status === 200) {
                this.props.history.push('/home');
            } else {
                this.props.history.push('/fail');
            }
        });
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
                <h1>Log in</h1>

                <form>
                    <div class="mb-4">
                        <label class="form-label">Email address</label>
                        <input name="email" class="form-control" value={this.state.email} onChange={this.changeEmailHandler}/>
                    </div>
                    <div class="mb-4">
                        <label class="form-label">Password</label>
                        <input name="password" class="form-control" value={this.state.password} onChange={this.changePasswordHandler}/>
                    </div>
                    <button type="submit" class="btn btn-success" onClick={this.LogInUser}>Submit</button>
                    <button className="btn btn-danger" style={{marginLeft: "10px"}} onClick={this.homePage}>Cancel</button>
                </form>
                
            </div>
        );
    }
}

export default Login;