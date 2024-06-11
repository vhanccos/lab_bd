from django.shortcuts import render
from .models import Pais

# Create
pais = Pais(paides="Pais 1", paicod="1", paiestreg="v")
pais.save()

pais = Pais(paides="Pais 2", paicod="2", paiestreg="f")
pais.save()

# Read
all_paises = Pais.objects.all()
for pais in all_paises:
    print(pais.paicod, pais.paides, pais.paiestreg)

# Update
pais = Pais.objects.get(paicod=1)
pais.paides = "Pais Y"
pais.save()

# Delete
pais = Pais.objects.get(paicod=1)
pais.delete()


def pais_list(request):
    all_paises = Pais.objects.all()
    return render(request, 'test/pais_list.html', {'paises': all_paises})