module Ruby
	public
	class Carrera < Prototipo
    
    attr_accessor:bicis,:codigo
    
		public
		def clonar()
		end

		public
		def initialize()
      @codigo=0
			@bicis=Array.new
		end
    
    public
    def aniadirparticipantes(bicicletas)
      @bicis=bicicletas
    end
    
	end
end
