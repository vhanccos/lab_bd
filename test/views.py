from django.shortcuts import render
from .models import Pais

# Create
print("Creamos paises")
pais = Pais(paides="Pais 1", paicod="1", paiestreg="v")
pais.save()

pais = Pais(paides="Pais 2", paicod="2", paiestreg="f")
pais.save()

pais = Pais(paides="Pais 3", paicod="3", paiestreg="f")
pais.save()

pais = Pais(paides="Pais 4", paicod="4", paiestreg="v")
pais.save()

pais = Pais(paides="Pais 5", paicod="5", paiestreg="f")
pais.save()

# Read
print("\nLos paises creados son:")
all_paises = Pais.objects.all()
for pais in all_paises:
    print(pais.paicod, pais.paides, pais.paiestreg)

# Update
print("\nActualizamos la descripcion de Pais 1:")
pais = Pais.objects.get(paicod=1)
pais.paides = "Pais Y"
pais.save()
all_paises = Pais.objects.all()
for pais in all_paises:
    print(pais.paicod, pais.paides, pais.paiestreg)

# Delete
print("\nEliminamos el Pais 2:")
pais = Pais.objects.get(paicod=2)
pais.delete()
all_paises = Pais.objects.all()
for pais in all_paises:
    print(pais.paicod, pais.paides, pais.paiestreg)


def pais_list(request):
    all_paises = Pais.objects.all()
    return render(request, 'test/pais_list.html', {'paises': all_paises})