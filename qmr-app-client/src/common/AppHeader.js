import React, { Component } from 'react';
import {
    Link,
    withRouter
} from 'react-router-dom';
import './AppHeader.css';
import { Layout, Menu, Dropdown, Icon } from 'antd';
import logo from '../images/logo.png';

const Header = Layout.Header;
    
class AppHeader extends Component {
    constructor(props) {
        super(props);   
        this.handleMenuClick = this.handleMenuClick.bind(this);   
    }

    handleMenuClick({ key }) {
      if(key === "logout") {
        this.props.onLogout();
      }
    }

    render() {
        let menuItems;
        if(this.props.currentUser) {
          menuItems = [
            <Menu.Item key="/">
              <Link to="/">
                <Icon type="home" className="nav-icon" />
              </Link>
            </Menu.Item>,
            <Menu.Item key="/poll/new">
            <Link to="/poll/new">
            </Link>
          </Menu.Item>,
          <Menu.Item key="/profile" className="profile-menu">
                <ProfileDropdownMenu 
                  currentUser={this.props.currentUser} 
                  handleMenuClick={this.handleMenuClick}/>
            </Menu.Item>
          ]; 
        } else {
          menuItems = [
            <Menu.Item key="/profile" className="profile-menu">
                <CandidateDropdownMenu 
                  currentUser={this.props.currentUser} 
                  handleMenuClick={this.handleMenuClick}/>
            </Menu.Item>              
          ];
        }

        return (
            <Header className="app-header">
            <div className="container">
              <div className="app-title" >
                <Link to="/">
                    <img src={logo} alt="" width="80%" height="80%" />
                </Link>
              </div>
              <Menu
                className="app-menu"
                mode="horizontal"
                selectedKeys={[this.props.location.pathname]}
                style={{ lineHeight: '64px' }} >
                  {menuItems}
              </Menu>
            </div>
          </Header>
        );
    }
}

function CandidateDropdownMenu(props){
    const dropdownMenu = (
        <Menu onClick={props.handleMenuClick} className="profile-dropdown-menu">
        <Menu.Item key="user-info" className="dropdown-item" disabled>
            <div className="user-full-name-info">
                <Menu.Item key="/login">
                <Link to="/login">Login</Link>
                </Menu.Item>
                <Menu.Item key="/signup">
                <Link to="/signup">Signup</Link>
                </Menu.Item>
            </div>
        </Menu.Item>
        </Menu>
    );

    return(
        <Dropdown 
            overlay={dropdownMenu} 
            trigger={['click']}
            getPopupContainer = { () => document.getElementsByClassName('profile-menu')[0]}>
            <a className="ant-dropdown-link">
                <Icon type="user" className="nav-icon" style={{marginRight: 0}} /> <Icon type="down" />
            </a>
        </Dropdown>
    );
}

function ProfileDropdownMenu(props) {
  const dropdownMenu = (
    <Menu onClick={props.handleMenuClick} className="profile-dropdown-menu">
      <Menu.Item key="user-info" className="dropdown-item" disabled>
        <div className="user-full-name-info">
          {props.currentUser.name}
        </div>
        <div className="username-info">
          @{props.currentUser.username}
        </div>
      </Menu.Item>
      <Menu.Divider />
      <Menu.Item key="profile" className="dropdown-item">
        <Link to={`/users/${props.currentUser.username}`}>Profile</Link>
      </Menu.Item>
      <Menu.Item key="logout" className="dropdown-item">
        Logout
      </Menu.Item>
    </Menu>
  );

  return (
    <Dropdown 
      overlay={dropdownMenu} 
      trigger={['click']}
      getPopupContainer = { () => document.getElementsByClassName('profile-menu')[0]}>
      <a className="ant-dropdown-link">
         <Icon type="user" className="nav-icon" style={{marginRight: 0}} /> <Icon type="down" />
      </a>
    </Dropdown>
  );
}


export default withRouter(AppHeader);