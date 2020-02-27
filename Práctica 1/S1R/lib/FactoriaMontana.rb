# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module Ruby
  class FactoriaMontana < FactoriaCarrerayBicicleta
    def crearCarrera()
      carrera = CarreraMontana.new.clonar
      return carrera
    end
    def crearBicicleta()
      bicicleta = BicicletaMontana.new.clonar
      return bicicleta
    end
  end
end
