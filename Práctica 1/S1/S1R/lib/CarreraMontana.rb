
require_relative "Carrera"

module Ruby
	public
	class CarreraMontana < Carrera

    attr_accessor :bicis
    

		def clonar()
			return CarreraMontana.new(@numero)
		end

		public
		def initialize(numero)
      super(numero)
      @bicis = Array.new
    end
    
    public 
    def correr
      puts "Comienza la carrera de carretera con #{@bicis.length}"
      abandonos = (@bicis.length*0.2).to_i
      puts "El numero de abandonos es #{abandonos}"
      for i in (0..abandonos-1)
        caido=rand(1..@bicis.size)
        puts "El participante #{caido} se ha retirado de la carrera de montania"
        @bicis.delete_at(caido-1)
      end
      @bicis = @bicis.shuffle
      puts "La carrera queda con #{@bicis.length}"
    end
    
    public 
    def mostrarranking
      puts "La carrera de montania ha acabado, resultados:"
      tamanio=@bicis.size-1
      for i in 0..tamanio
        puesto=i+1
        puts "Carrera #{@codigo} Puesto #{puesto} -> Bicicleta #{(@bicis[i].id).to_s}"
      end
    end
    
	end
end
