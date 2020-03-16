

module Ruby
	public
	class Bicicleta

    attr_accessor:id
    
		def clonar()
      return Bicicleta.new(@id)
		end

		public
		def initialize()
			@_id=0
		end
    
	end
end
