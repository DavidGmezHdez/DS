=begin
require('../Ruby/Cliente.rb');
=end
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
			@cliente.gestionar
		end
    
	end
end
