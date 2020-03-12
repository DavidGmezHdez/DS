# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative "BicicletaCarretera"
require_relative "CarreraCarretera"

module Ruby
  class FactoriaCarretera < FactoriaCarrerayBicicleta
    def crearCarrera(id)
      carrera = CarreraCarretera.new(id)
      return carrera
    end
    def crearBicicleta(id)
      bicicleta = BicicletaCarretera.new(id)
      return bicicleta
    end
  end
end
