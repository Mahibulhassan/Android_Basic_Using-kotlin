package com.hellohasan.mvvm_dagger.data.local.db.subject

import com.hellohasan.mvvm_dagger.core.DataFetchCallback
import com.hellohasan.mvvm_dagger.data.local.db.AppDatabase
import com.hellohasan.mvvm_dagger.data.repository.subject.Subject
import javax.inject.Inject

class SubjectLocalDataSourceImpl @Inject constructor(db: AppDatabase) : SubjectLocalDataSource {

    private val subjectDao = db.subjectDao()

    override suspend fun createSubject(subject: Subject, callback: DataFetchCallback<Long>) {
        try {
            callback.onSuccess(subjectDao.insert(subject))
        } catch (e: Exception) {
            callback.onError(e)
        }
    }

    override suspend fun getSubjectList(callback: DataFetchCallback<MutableList<Subject>>) {
        try {
            callback.onSuccess(subjectDao.getAll())
        } catch (e: Exception) {
            callback.onError(e)
        }
    }

    override suspend fun updateSubject(subject: Subject, callback: DataFetchCallback<Int>) {
        try {
            callback.onSuccess(subjectDao.update(subject))
        } catch (e: Exception) {
            callback.onError(e)
        }
    }

    override suspend fun deleteSubject(subject: Subject, callback: DataFetchCallback<Int>) {
        try {
            callback.onSuccess(subjectDao.delete(subject))
        } catch (e: Exception) {
            callback.onError(e)
        }
    }
}