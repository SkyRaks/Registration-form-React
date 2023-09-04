import React, { Component } from 'react';

class FailToAccess extends Component {
    constructor(props) {
        super(props)

        this.state = {

        }
    }

    render() {
        return (
            <div>
                <h3>if you see this it means tha you failed to access</h3>
            </div>
        );
    }
}

export default FailToAccess;