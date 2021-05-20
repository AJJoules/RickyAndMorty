package ng.com.ajsprojects.rickyandmorty

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.SingleObserver
import io.reactivex.SingleSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ng.com.ajsprojects.rickyandmorty.api.RetrofitService
import ng.com.ajsprojects.rickyandmorty.models.CharacterData
import retrofit2.Response

class ViewModel : ViewModel() {

    private val characters: MutableLiveData<CharacterData> by lazy {
        MutableLiveData<CharacterData>().also {
            fetchName()
        }

    }

    fun getCharacters(): LiveData<CharacterData> {
        return characters
    }

    private fun fetchName() {
        val apiInterface = RetrofitService.getRetrofitInstance().fetchCharacterName()
        apiInterface.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<Response<CharacterData>> {
                override fun onSuccess(t: Response<CharacterData>) {
                    characters.value = t.body()
                    Log.d("character", "" + t.body())
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                }


            })

    }

}

private fun <T> SingleSource<T>.subscribe(singleObserver: SingleObserver<Response<CharacterData>>) {
    TODO("Not yet implemented")
}
