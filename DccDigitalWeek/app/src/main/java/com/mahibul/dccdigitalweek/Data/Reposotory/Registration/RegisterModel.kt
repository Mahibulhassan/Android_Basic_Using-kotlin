package com.mahibul.dccdigitalweek.Data.Reposotory.Registration

import com.mahibul.dccdigitalweek.core.DataFatchCallback

interface RegisterModel {
     fun registrationUser(registerData: RegisterData,callback: DataFatchCallback<Int>)
}