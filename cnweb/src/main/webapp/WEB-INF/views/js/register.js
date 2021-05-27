function registerForm()
{
    // Bước 1: Lấy giá trị 
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    var repeat_password = document.getElementById('repeat password').value;
 
    // Bước 2: Kiểm tra dữ liệu hợp lệ hay không
    if (username == ''){
        alert('Bạn chưa nhập tên đăng nhập');
    }
    else if (password == '')
    {
        alert('Bạn chưa nhập mật khẩu');
    }
    else if (password != repeat_password)
    {
    	alert('Mật khẩu nhập lại không trùng với mật khẩu vừa nhập');
    }
    else{
        return true;
    }
 
    return false;
}