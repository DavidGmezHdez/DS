#encoding: UTF-8
require_relative "Cliente.rb"

module Ruby
	class Proyecto
  
    @cliente=Cliente.new
  
   
    def self.corrercarreras
      for i in @cliente.carreras
        i.correr
      end
    end
    
    def self.obtenerranking
      for i in @cliente.carreras
        i.mostrarranking
      end
    end
  
    
		def self.main
      @cliente.gestionar
      corrercarreras
      obtenerranking
    end
    
	end
  Proyecto.main
end
