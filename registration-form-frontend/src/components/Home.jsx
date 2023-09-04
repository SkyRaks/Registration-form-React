import React, { Component } from 'react';
import HomeService from '../services/HomeService';

class Home extends Component {
    constructor(props) {
        super(props)

        this.state = {
            users: []
        }
        this.Register = this.Register.bind(this);
        this.Login = this.Login.bind(this);
    }

    componentDidMount() {
        HomeService.getUsers().then((res) => {
            this.setState({users: res.data});
        });
    }

    Register(){
        this.props.history.push('/register');
    }

    Login() {
        this.props.history.push('/login');
    }

    render() {
        return (
            <div class="col-8 mx-auto my-4">
                <h1 className="text-center">Welcome</h1>
                <h2 className="text-center">Registration-form App Home Page</h2>
                    <button className="btn btn-primary" style={{marginBottom: "10px"}} onClick={this.Register}>
                        Register
                    </button>
                    <button className="btn btn-primary" style={{marginLeft: "10px", marginBottom: "10px"}} onClick={this.Login}>
                        Log in
                    </button>
                
                    <table className="table table-striped table-bordered table-dark">

                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Password</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.users.map(
                                    users => 
                                    <tr key = {users.id}>
                                        <td>{users.username}</td>
                                        <td>{users.email}</td>
                                        <td>{users.password}</td>

                                    </tr>
                                )
                            }
                        </tbody>

                    </table>
            </div>
        );
    }
}

export default Home;