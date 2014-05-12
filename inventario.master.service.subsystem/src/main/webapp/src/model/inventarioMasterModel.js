define(['model/_inventarioMasterModel'], function() { 
    App.Model.InventarioMasterModel = App.Model._InventarioMasterModel.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('inventario-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.InventarioModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.inventarioEntity,options);
            }
        }
    });

    App.Model.InventarioMasterList = App.Model._InventarioMasterList.extend({
        model: App.Model.InventarioMasterModel
    });

    return  App.Model.InventarioMasterModel;

});