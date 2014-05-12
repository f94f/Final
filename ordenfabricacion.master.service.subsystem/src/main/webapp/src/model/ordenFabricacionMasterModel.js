define(['model/_ordenFabricacionMasterModel'], function() { 
    App.Model.OrdenFabricacionMasterModel = App.Model._OrdenFabricacionMasterModel.extend({
		initialize: function() {
            this.on('invalid', function(model,error) {
                Backbone.trigger('ordenFabricacion-master-model-error', error);
            });
        },
        validate: function(attrs, options){
        	var modelMaster = new App.Model.OrdenFabricacionModel();
        	if(modelMaster.validate){
            	return modelMaster.validate(attrs.ordenFabricacionEntity,options);
            }
        }
    });

    App.Model.OrdenFabricacionMasterList = App.Model._OrdenFabricacionMasterList.extend({
        model: App.Model.OrdenFabricacionMasterModel
    });

    return  App.Model.OrdenFabricacionMasterModel;

});