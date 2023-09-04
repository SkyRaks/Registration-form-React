import axios from "axios";

const GET_ALL_USERS_API_BASE_URL = "http://localhost:8080/home/getAllUsers";

const REGISTER_API_BASE_URL = "http://localhost:8080/home/register";

const LOGIN_API_BASE_URL = "http://localhost:8080/home/login";

class HomeService {

    getUsers() {
        return axios.get(GET_ALL_USERS_API_BASE_URL);
    }

    createUser(user) {
        return axios.post(REGISTER_API_BASE_URL, user);
    }

    findUser(user) {
        return axios.post(LOGIN_API_BASE_URL, user);
    }
}

export default new HomeService()