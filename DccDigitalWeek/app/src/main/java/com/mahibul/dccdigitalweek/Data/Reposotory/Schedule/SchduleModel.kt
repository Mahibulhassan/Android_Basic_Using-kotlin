package com.mahibul.dccdigitalweek.Data.Reposotory.Schedule

import com.mahibul.dccdigitalweek.core.DataFatchCallback

interface SchduleModel {
    fun getSchdule(callback: DataFatchCallback<ScheduleTime>)
}