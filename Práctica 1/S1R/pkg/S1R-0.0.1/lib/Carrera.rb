module Ruby
	public
	class Carrera
    
    attr_accessor:bicis,:codigo
    
		def clonar
      return Carrera.new(@codigo)
		end

		public
		def initialize(codigo)
      @codigo=codigo
			
		end
    
    public
    def aniadirparticipantes(bicicletas)
      @bicis=bicicletas
    end
    
    def mostrarranking
    end
    
	end
end
