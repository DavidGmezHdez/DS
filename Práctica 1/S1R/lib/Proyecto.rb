=begin
require('../Ruby/Cliente.rb');
=end
#encoding:utf-8
require_relative "Cliente"

module Ruby
	public
	class Proyecto
  
    @cliente=Cliente.new
  
    public 
    def corrercarreras
      for i in @cliente.carreras.length
        @cliente.carreras[i].correr
      end
    end
  
    
    public
		def main()
      puts "Hola"


      
		end
    
	end
end
