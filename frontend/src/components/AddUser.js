import React, { useState, useEffect } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import UserService from "../services/UserService";

const AddUser = () => {
  const [name, setName] = useState("");
  const [studentId, setStudentId] = useState("");
  const [emailId, setEmailId] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();
  const { id } = useParams();

  const saveOrUpdateUser = (e) => {
    e.preventDefault();

    const user = { name, studentId, emailId, password };

    if (id) {
      UserService.updateUser(id, user)
        .then((response) => {
          navigate("/users");
        })
        .catch((error) => {
          console.log(error);
        });
    } else {
      UserService.createUser(user)
        .then((response) => {
          console.log(response.data);

          navigate("/users");
        })
        .catch((error) => {
          console.log(error);
        });
    }
  };

  useEffect(() => {
    UserService.getUserById(id)
      .then((response) => {
        setName(response.data.name);
        setStudentId(response.data.studentId);
        setEmailId(response.data.emailId);
        setPassword(response.data.password);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const title = () => {
    if (id) {
      return <h2 className="text-center">수정 페이지</h2>;
    } else {
      return <h2 className="text-center">추가 페이지</h2>;
    }
  };

  return (
    <div>
      <br />
      <br />
      <div className="container">
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            {title()}
            <div className="card-body">
              <form>
                <div className="form-group mb-2">
                  <label className="form-label"> 이름 :</label>
                  <input
                    type="text"
                    placeholder="이름을 입력하세요"
                    name="name"
                    className="form-control"
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                  ></input>
                </div>

                <div className="form-group mb-2">
                  <label className="form-label"> 학번 :</label>
                  <input
                    type="text"
                    placeholder="학번을 입력하세요"
                    name="studentId"
                    className="form-control"
                    value={studentId}
                    onChange={(e) => setStudentId(e.target.value)}
                  ></input>
                </div>

                <div className="form-group mb-2">
                  <label className="form-label"> 이메일 :</label>
                  <input
                    type="email"
                    placeholder="이메일을 입력하세요"
                    name="emailId"
                    className="form-control"
                    value={emailId}
                    onChange={(e) => setEmailId(e.target.value)}
                  ></input>
                </div>

                <div className="form-group mb-2">
                  <label className="form-label"> 비밀번호 :</label>
                  <input
                    type="password"
                    placeholder="비밀번호를 입력하세요"
                    name="password"
                    className="form-control"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                  ></input>
                </div>

                <button
                  className="btn btn-success"
                  onClick={(e) => saveOrUpdateUser(e)}
                >
                  저장{" "}
                </button>

                <Link to="/users" className="btn btn-danger">
                  {" "}
                  취소{" "}
                </Link>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddUser;
