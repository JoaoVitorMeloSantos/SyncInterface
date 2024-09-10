package com.joao.syncinterface;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LikesViewModel extends ViewModel {

    private final MutableLiveData<String> nome = new MutableLiveData<>("Irineu");
    private final MutableLiveData<String> sobrenome = new MutableLiveData<>("Você Não Sabe Nem Eu");
    private final MutableLiveData<Integer> likes = new MutableLiveData<>(0);
    private final MutableLiveData<Integer> imagemLikes = new MutableLiveData<>(R.drawable.like);

    public LiveData<String> getNome() {
        return nome;
    }

    public LiveData<String> getSobrenome() {
        return sobrenome;
    }

    public LiveData<Integer> getLikes() {
        return likes;
    }

    public LiveData<Integer> getImagemLikes() {
        return imagemLikes;
    }

    public void darLike() {
        int currentLikes = likes.getValue() != null ? likes.getValue() : 0;
        currentLikes++;
        likes.setValue(currentLikes);

        if (currentLikes >= 0 && currentLikes <= 3) {
            imagemLikes.setValue(R.drawable.like);
        } else if (currentLikes > 3 && currentLikes <= 9) {
            imagemLikes.setValue(R.drawable.heart);
        } else if (currentLikes > 9) {
            imagemLikes.setValue(R.drawable.fire);
        }
    }
}

