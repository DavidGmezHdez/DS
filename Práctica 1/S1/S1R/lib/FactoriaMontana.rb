# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative "BicicletaMontana"
require_relative "CarreraMontana"

module Ruby
  class FactoriaMontana < FactoriaCarrerayBicicleta
    def crearCarrera(id)
      carrera = CarreraMontana.new(id)
      return carrera
    end
    
    def crearBicicleta(id)
      bicicleta = BicicletaMontana.new(id)
      return bicicleta
    end
  end
end
