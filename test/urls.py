from django.urls import path
from . import views

urlpatterns = [
    path('paises/', views.pais_list, name='pais_list'),
]
