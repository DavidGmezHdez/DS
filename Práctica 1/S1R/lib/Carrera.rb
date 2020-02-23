require('./Ruby/Prototipo.rb');

module Ruby
	public
	class Carrera < Prototipo
    
    attr_accessor:bicis
    attr_accessor:codigo
    
		public
		def clonar()
			# Not yet implemented
		end

		public
		def initialize(numero)
      @codigo=numero
			@bicis=Array.new
		end
    
    public
    def aniadirparticipantes(bicicletas)
      @bicis=bicicletas
    end
    
	end
end
