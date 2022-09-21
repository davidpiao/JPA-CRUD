import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import UserService from "../services/UserService";

const ListUser = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    getAllUsers();
  }, []);

  const getAllUsers = () => {
    UserService.getAllUsers()
      .then((response) => {
        setUsers(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const deleteUser = (userID) => {
    UserService.deleteUser(userID)
      .then((response) => {
        getAllUsers();
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="container">
      <h2 className="text-center"> 유저 리스트</h2>
      <Link to="/add-user" className="btn btn-primary mb-2">
        {" "}
        사용자 추가{" "}
      </Link>
      <table className="table table-bordered table-striped">
        <thead>
          <th> ID </th>
          <th> 이름 </th>
          <th> 학번 </th>
          <th> 이메일 </th>
          <th> 부가기능 </th>
        </thead>
        <tbody>
          {users.map((user) => (
            <tr key={user.id}>
              <td> {user.id} </td>
              <td> {user.name} </td>
              <td>{user.studentId}</td>
              <td>{user.emailId}</td>
              <td>
                <Link className="btn btn-info" to={`/edit-user/${user.id}`}>
                  수정
                </Link>
                <button
                  className="btn btn-danger"
                  onClick={() => deleteUser(user.id)}
                  //   style={{ marginLeft: "10px" }}
                >
                  {" "}
                  삭제
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListUser;
