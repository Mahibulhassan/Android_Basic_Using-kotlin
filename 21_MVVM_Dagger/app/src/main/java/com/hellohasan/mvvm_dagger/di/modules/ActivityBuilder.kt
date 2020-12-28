package com.hellohasan.mvvm_dagger.di.modules

import com.hellohasan.mvvm_dagger.di.annotation.ActivityScope
import com.hellohasan.mvvm_dagger.ui.student.student_list.StudentListActivity
import com.hellohasan.mvvm_dagger.ui.subject.subject_list.SubjectListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindStudentListActivity(): StudentListActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindSubjectActivity(): SubjectListActivity
}