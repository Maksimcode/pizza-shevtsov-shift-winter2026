package com.example.shevtsov_pizza_shift_winter2026.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shevtsov_pizza_shift_winter2026.domain.usecase.GetPizzasUseCase
import com.example.shevtsov_pizza_shift_winter2026.presentation.state.PizzaCatalogState
import kotlinx.coroutines.launch

class PizzaCatalogViewModel(
    private val getPizzasUseCase: GetPizzasUseCase
) : ViewModel() {

    private val _state: MutableLiveData<PizzaCatalogState> =
        MutableLiveData(PizzaCatalogState.Initial)

    val state: LiveData<PizzaCatalogState> = _state

    fun loadPizzas() {
        if (_state.value is PizzaCatalogState.Loading) {
            return
        }
        _state.value = PizzaCatalogState.Loading
        viewModelScope.launch {
            try {
                val pizzas = getPizzasUseCase()
                _state.value = PizzaCatalogState.Content(pizzas)
            } catch (e: Exception) {
                _state.value = PizzaCatalogState.Error(e.message ?: "Неизвестная ошибка")
            }
        }
    }
}