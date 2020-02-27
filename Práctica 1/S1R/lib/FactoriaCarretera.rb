# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Ruby
  class FactoriaCarretera < FactoriaCarrerayBicicleta
    def crearCarrera()
      carrera = CarreraCarretera.new.clonar
      return carrera
    end
    def crearBicicleta()
      bicicleta = BicicletaCarretera.new.clonar
      return bicicleta
    end
  end
end
